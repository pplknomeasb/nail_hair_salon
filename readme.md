
Link to ERD Model:
https://drive.google.com/file/d/1e4suxdBgOFMWi013gcbefU3QGgfwxdDy/view?usp=sharing

Link to Users Board:
https://docs.google.com/document/d/1OgjsBqGHKIctnY3v504u3xJro2GCQAh01Fhlz4KN5-g/edit?usp=sharing

Front-End : Thymeleaf
Backend : Springboot, Spring JPA, Spring Security
This Hair and Nail Salon is to allow 3 types of users; 
Admin and Owner, Users and Employees, and clients.

Admin and Owner have complete control over all of the userdata except 
for unique properties; i.e name, address, phone, etc.

At database level, there are 4 models.  The Events model contains 
data pertaining an event which is appointment criteria.  The 
Employee Model will contain information for all individuals with
login information; all user names are email and passwords are to be
set by either the Owner or Admin; owner and Admin have god privileges.
Clients are not considered "users" because adding information to the
back-end is the only role.