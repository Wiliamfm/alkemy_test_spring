FROM postgres
COPY ./1.sql /docker-entrypoint-initdb.d/
COPY ./2.sql /docker-entrypoint-initdb.d/
ENV POSTGRES_PASSWORD=1234
ENV POSTGRES_DB=alkemy