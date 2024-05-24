-- Create the user 
create user una
  identified by una
  default tablespace USERS
  temporary tablespace TEMP
  profile DEFAULT;
-- Grant/Revoke role privileges 
grant connect to una;
grant resource to una;
grant dba to una;
-- Grant/Revoke system privileges 
grant unlimited tablespace to una;
grant create session to una;