# Usar la imagen oficial de OpenJDK 21
FROM openjdk:21-jdk-slim

# Autor del contenedor (opcional)
LABEL authors="Jose Angel"

# Establecer el directorio de trabajo en el contenedor
WORKDIR /app

# Copiar el archivo .jar generado al contenedor
COPY target/Gasolinera-1.0-SNAPSHOT.jar /app/Gasolinera.jar

# Exponer el puerto dinámico en el contenedor
EXPOSE 10000

# Establecer la variable de entorno para el puerto (Render asigna un puerto aleatorio)
ENV PORT=10000

# Iniciar la aplicación Spring Boot
CMD ["java", "-jar", "Gasolinera.jar"]
