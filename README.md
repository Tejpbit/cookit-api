# CookIT API
The backend of CookIT, a cooking application meant to deal with the hazzel of converting types and reading recipies.

## Running the project

1) clone the repo
2) if you don't have postgres installed, run `docker-compose up` to bring up a postgres container
3) set the DB_URL, DB_USER and DB_PASSWORD environment variables (can be found in the compose file if you are using that)
4) build with gradle and run the project
