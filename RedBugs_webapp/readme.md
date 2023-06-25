docker container rm redbugsdocker container run --name redbugs -e MYSQL_ROOT_PASSWORD=redbugs -e MYSQL_DATABASE=redbugs -p 3306:3306 -d mysql:8
docker container run --name redbugs -e MYSQL_ROOT_PASSWORD=redbugs -e MYSQL_DATABASE=redbugs -p 3306:3306 -d mysql:8
docker container run --name myredbugs -e MYSQL_ROOT_PASSWORD=redbugs -e MYSQL_DATABASE=redbugs -p 3306:3306 -d mysql:8
