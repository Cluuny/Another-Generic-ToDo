CREATE USER api_rest_user WITH PASSWORD 'api_rest_user_password';
GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA another_generic_todo_db TO api_rest_user;