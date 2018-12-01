# Build
mvn clean package && docker build -t com.fmoraes/debzium .

# RUN

docker rm -f debzium || true && docker run -d -p 8080:8080 -p 4848:4848 --name debzium com.fmoraes/debzium 