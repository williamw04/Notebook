1. Setup database to hold information...
	- A way to process gmails

| Unique_ID | gmail  | password | has_account | order_status |
| --------- | ------ | -------- | ----------- | ------------ |
| rand gen  | string | string   | boolean     | boolean      |
CREATE TABLE users (
    unique_id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    gmail VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    has_account BOOLEAN NOT NULL,
    order_status BOOLEAN
);

>[!Setting Up Postgresql in Docker Container]
>Following this guide should be good enough. 
>[docker postgres guide](https://www.docker.com/blog/how-to-use-the-postgres-docker-official-image/))
>One point I wanna highlight is the user and password part
>```bash
>docker run --name johnny -e POSTGRES_PASSWORD=mysecretpassword -d postgres`
>```
>--name defines the name of the image, the postgres_password is needed for postgresql to run properly, postgres is the default user created alongside the db.
>
>So if you're getting the error root not found, make sure to specify the user as postgres in the compose.yaml file...
>Also when using the yaml file (docker compose up) the container is named after directory by default?




>[!Issues creating a table]
>	With postgresql 15, there's an update with permission i.e revoking all CREATE permission from all users except a database owner from the public (or default) schema
>Note remember that postgresql is a object-relational database management system (ORDMS) not the actual database so you have to create a database first. Which would look like:
>```
>CREATE DATABASE BALLS;
CREATE USER EXAMPLE_USER WITH ENCRYPTED PASSWORD 'Sup3rS3cret';
GRANT ALL PRIVILEGES ON DATABASE ACCOUNT_TRACKER TO postgres;
\c EXAMPLE_DB postgres 
GRANT ALL ON SCHEMA public TO postgres;
>```

Question: What does it mean to map the port of my container to the port of my server. What are ports? Some how realated to network programming

```bash
docker run --name some-postgres -e POSTGRES_PASSWORD=mysecretpassword -d -p 5432:5432 postgres
```
^^^ Creates a container named some-postgres using the offical postgres docker  image, with a password connecting the container port 5432 to my server 5432 making  it so now your postgres is accessible from your `public-server-ip:5432`.

1. Automating checkout process
2. A way to read a main email




