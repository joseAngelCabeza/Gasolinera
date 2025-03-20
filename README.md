Gasolinera API
  Este proyecto es una API para gestionar el sistema de una gasolinera. La aplicación permite manejar información sobre los surtidores, productos, precios, suministros y más.

Modelos principales
  Precio: Aquí se gestionan los precios de los productos que se venden en la gasolinera. Cada producto tiene un precio asociado.
  Producto: Son los productos que se venden, como gasolina, diésel, etc.
  Suministro: Representa la transacción de combustible que se realiza en un surtidor. Aquí se registran detalles como el volumen de litros y el importe.
  Surtidor: Son las estaciones de combustible en la gasolinera. Cada surtidor tiene un identificador único.
  Surtidor-Producto: Relaciona los surtidores con los productos disponibles en cada uno, para saber qué tipo de combustible ofrece cada estación.
  Tanque: Cada surtidor tiene un tanque que almacena el combustible, y aquí se gestiona la cantidad de combustible disponible.
¿Cómo funciona la API?
  La API se encarga de gestionar toda la información relacionada con estos modelos. Permite:

  Crear, leer, actualizar y eliminar precios, productos, surtidores y suministros.
  Consultar el historial de suministros por surtidor, producto o rango de fechas.
  Mantener actualizados los niveles de combustible en los surtidores y tanques.
Endpoints
  Los endpoints de la API están disponibles para interactuar con todos estos modelos, y te permiten gestionar el sistema de la gasolinera de forma sencilla.
