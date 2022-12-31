mvn -Dmaven.test.skip=true clean package
docker build --tag=sesami-assignment:latest .
docker compose up