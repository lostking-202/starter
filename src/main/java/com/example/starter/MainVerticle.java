package com.example.starter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.mysqlclient.MySQLConnectOptions;
import io.vertx.mysqlclient.MySQLPool;
import io.vertx.sqlclient.PoolOptions;
import io.vertx.sqlclient.Row;
import io.vertx.sqlclient.RowSet;
import io.vertx.sqlclient.SqlClient;
import io.vertx.sqlclient.Tuple;
import io.vertx.sqlclient.templates.SqlTemplate;
import io.vertx.sqlclient.templates.impl.SqlTemplateImpl;
import jakarta.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class MainVerticle extends AbstractVerticle {

  public static void main(String[] args) {
    Vertx vertx = Vertx.vertx();
    vertx.deployVerticle(new MainVerticle());
  }

  static SqlClient client;

  static {
    MySQLConnectOptions connectOptions = new MySQLConnectOptions()
      .setHost("135.251.45.18")
      .setUser("root")
      .setPassword("root")
      .setPort(3306)
      .setDatabase("sbell_tem")
      .setCharacterEncoding(StandardCharsets.UTF_8.name());

    PoolOptions poolOptions = new PoolOptions().setMaxSize(5);

    // 创建客户端池
    client = MySQLPool.client(connectOptions, poolOptions);
  }

  @Override
  public void start(Promise<Void> startPromise) throws Exception {
    HttpServer server = vertx.createHttpServer();
    Router router = Router.router(vertx);


    router.get("/person/:id").handler(ctx->{
      String id=ctx.pathParam("id");
      Map<String,Object> params1= Map.of("id",id);
      SqlTemplate.forQuery(client, "select * from person where id=#{id}").mapTo(Person.class).execute(params1).onSuccess(roles -> ctx.response().end(Json.encode(roles))).onFailure(res->res.printStackTrace());
    });

    router.get("/role/:id").handler(ctx->{
      String id=ctx.pathParam("id");
      Map<String,Object> params1= Map.of("id",id);
      SqlTemplate.forQuery(client, "select * from t_iot_sys_role where n_id=#{id}").mapTo(TIotSysRoleRowMapper.INSTANCE).execute(params1).onSuccess(roles -> {
        ctx.response().end(Json.encode(roles));
      }).onFailure(res->{
        res.printStackTrace();
        ctx.response().end("failed");
      });
    });

    router.get("/role/name/:name").handler(ctx->{
      String name=ctx.pathParam("name");
      Map<String,Object> params1= Map.of("name",name);
      SqlTemplate.forQuery(client, "select * from t_iot_sys_role where c_name=#{name}").mapTo(TIotSysRoleRowMapper.INSTANCE).execute(params1).onSuccess(roles -> {
        ctx.response().putHeader("content-type", "text/html;charset=UTF-8").end(Json.encode(roles));
      }).onFailure(res->{
        res.printStackTrace();
        ctx.response().end("failed");
      });
    });

    router.get("/hello").handler(ctx->{

      System.out.println("success");
      ctx.response().putHeader("content-type", "text/html;charset=UTF-8").end("你好");
    });

    router.get("/role").handler(ctx->{
      String id=ctx.request().getParam("id");
      System.out.println(id);
      ctx.response().end("success");
    });

    router.post("/role").handler(ctx->{
      ctx.request().body().onSuccess(buffer -> {
        System.out.println(buffer.toString());
      });
      ctx.response().end("success");
    });

    server.requestHandler(router).listen(8080);


  }
}
