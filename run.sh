mvn -Dmaven.test.skip=true clean package install
docker build --tag=sesami-assignment:latest .
docker compose up