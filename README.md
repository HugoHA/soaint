# soaint
# Proyecto de Prueba Soaint S.A.C

Auth Basic:
user: admin
pass: admin

ENDPOINTS:
** http://localhost:8080/productos       -->METHOD(GET)        //Listar todos los productos
** http://localhost:8080/productos       -->METHOD(POST)       //
  TRAMA:
        {
          "nombre":"televisores",
          "precio":1700.500
        }
** http://localhost:8080/productos/5      -->METHOD(GET)      //buscar producto por id(codigo)
** http://localhost:8080/productos/3      -->METHOD(DELETE)   //eliminar producto por id(codigo)
** http://localhost:8080/productos/4      -->METHOD(PUT)      //actualizar producto por id(codigo)
      TRAMA:
        {
          "nombre":"televisores",
          "precio":1700.500
        }
        
        
INTERFAZ SWAGGER DE PRUEBA DE LA API

http://localhost:8080/swagger-ui.html
