--- 

title: Employee Management System 

language_tabs: 
   - shell 

toc_footers: 
   - <a href='#'>Sign Up for a Developer Key</a> 
   - <a href='https://github.com/lavkumarv'>Documentation Powered by lav</a> 

includes: 
   - errors 

search: true 

--- 

# Introduction 

Employee Management System 

**Version:** 1.0 

# /API/V1/DEPARTMENTS
## ***GET*** 

**Summary:** Get all departments

**Description:** These are some implementation notes

### HTTP Request 
`***GET*** /api/v1/departments` 

**Responses**

| Code | Description |
| ---- | ----------- |
| 200 | OK |
| 401 | Unauthorized |
| 403 | Forbidden |
| 404 | Not Found |

## ***POST*** 

**Summary:** Create a new department

**Description:** These are some implementation notes

### HTTP Request 
`***POST*** /api/v1/departments` 

**Parameters**

| Name | Located in | Description | Required | Type |
| ---- | ---------- | ----------- | -------- | ---- |
| department | body | department | Yes |  |

**Responses**

| Code | Description |
| ---- | ----------- |
| 200 | OK |
| 201 | Created |
| 401 | Unauthorized |
| 403 | Forbidden |
| 404 | Not Found |

# /API/V1/DEPARTMENTS/{ID}
## ***DELETE*** 

**Summary:** Delete a department by Id

**Description:** These are some implementation notes

### HTTP Request 
`***DELETE*** /api/v1/departments/{id}` 

**Parameters**

| Name | Located in | Description | Required | Type |
| ---- | ---------- | ----------- | -------- | ---- |
| id | path | id | Yes | long |

**Responses**

| Code | Description |
| ---- | ----------- |
| 200 | OK |
| 204 | No Content |
| 401 | Unauthorized |
| 403 | Forbidden |

# /API/V1/EMPLOYEES
## ***GET*** 

**Summary:** Get all employees

**Description:** These are some implementation notes

### HTTP Request 
`***GET*** /api/v1/employees` 

**Responses**

| Code | Description |
| ---- | ----------- |
| 200 | OK |
| 401 | Unauthorized |
| 403 | Forbidden |
| 404 | Not Found |

## ***POST*** 

**Summary:** Create new employee

**Description:** These are some implementation notes

### HTTP Request 
`***POST*** /api/v1/employees` 

**Parameters**

| Name | Located in | Description | Required | Type |
| ---- | ---------- | ----------- | -------- | ---- |
| employee | body | employee | Yes |  |

**Responses**

| Code | Description |
| ---- | ----------- |
| 200 | OK |
| 201 | Created |
| 401 | Unauthorized |
| 403 | Forbidden |
| 404 | Not Found |

# /API/V1/EMPLOYEES/{ID}
## ***DELETE*** 

**Summary:** Delete an employee

**Description:** These are some implementation notes

### HTTP Request 
`***DELETE*** /api/v1/employees/{id}` 

**Parameters**

| Name | Located in | Description | Required | Type |
| ---- | ---------- | ----------- | -------- | ---- |
| id | path | id | Yes | long |

**Responses**

| Code | Description |
| ---- | ----------- |
| 200 | OK |
| 204 | No Content |
| 401 | Unauthorized |
| 403 | Forbidden |

# /ERROR
## ***GET*** 

**Summary:** error

### HTTP Request 
`***GET*** /error` 

**Responses**

| Code | Description |
| ---- | ----------- |
| 200 | OK |
| 401 | Unauthorized |
| 403 | Forbidden |
| 404 | Not Found |

## ***POST*** 

**Summary:** error

### HTTP Request 
`***POST*** /error` 

**Responses**

| Code | Description |
| ---- | ----------- |
| 200 | OK |
| 201 | Created |
| 401 | Unauthorized |
| 403 | Forbidden |
| 404 | Not Found |

## ***PUT*** 

**Summary:** error

### HTTP Request 
`***PUT*** /error` 

**Responses**

| Code | Description |
| ---- | ----------- |
| 200 | OK |
| 201 | Created |
| 401 | Unauthorized |
| 403 | Forbidden |
| 404 | Not Found |

## ***DELETE*** 

**Summary:** error

### HTTP Request 
`***DELETE*** /error` 

**Responses**

| Code | Description |
| ---- | ----------- |
| 200 | OK |
| 204 | No Content |
| 401 | Unauthorized |
| 403 | Forbidden |

## ***OPTIONS*** 

**Summary:** error

### HTTP Request 
`***OPTIONS*** /error` 

**Responses**

| Code | Description |
| ---- | ----------- |
| 200 | OK |
| 204 | No Content |
| 401 | Unauthorized |
| 403 | Forbidden |

## ***PATCH*** 

**Summary:** error

### HTTP Request 
`***PATCH*** /error` 

**Responses**

| Code | Description |
| ---- | ----------- |
| 200 | OK |
| 204 | No Content |
| 401 | Unauthorized |
| 403 | Forbidden |

<!-- Converted with the swagger-to-slate https://github.com/lavkumarv/swagger-to-slate -->
