#De la imagen que partimos
FROM openjdk:8-jre-alpine

#Directorio de trabajo
WORKDIR /

#Copiamos el uber-jar en el directorio de trabajo
COPY docker/keystoremultimarca.p12 /opt/apps/
RUN mkdir app && chmod 777 app
COPY target/proyecto-0.0.1-SNAPSHOT.jar /app
WORKDIR /app

#Exponemos el puerto 8085
EXPOSE 8085

#Comando que se ejecutará una vez ejecutemos el contendor
CMD ["java","-jar","proyecto-0.0.1-SNAPSHOT.jar"]
