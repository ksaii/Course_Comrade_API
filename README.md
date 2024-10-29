# Course_Comrade_API
Course_Comrade_API is a collaborative project designed to centralize and manage class information for UTSA students. This API provides seamless access to course details, schedules, and resources, empowering users to navigate their academic journey more efficiently. Note: This API is not officially affiliated with UTSA.


# Course_Comrade_API Documentation

### Base URL

**Base URL:** Replace `https://your-base-url.com` with your actual Heroku app URL or any other hosting provider's URL. By Default the url in application.properties is set to JAWSDB configure the file as needed. The Procfile can be deleted if using a host that doesn't require it.

Example Endpoint: `https://your-base-url.com/api/professors`


## Professors 

### Endpoints

#### 1. Get All Professors
- **Method:** `GET`
- **URL:** `/api/professors`
- **Description:** Retrieves a list of all professors.
- **Response:** List of [Professor objects](#professors-object) .

---

#### 2. Get Professor by ID
- **Method:** `GET`
- **URL:** `/api/professors/{professorId}`
- **Description:** Retrieves a specific professor by their ID.
- **Path Parameter:**
    - `professorId` (int): ID of the professor.
- **Response:** [Professor object](#professors-object).

---

#### 3. Create Professor
- **Method:** `POST`
- **URL:** `/api/professors`
- **Description:** Creates a new professor.
- **Request Body:** [Professor object](#professors-object).
- **Response:** Newly created `Professors` object.

---

#### 4. Update Professor
- **Method:** `PUT`
- **URL:** `/api/professors/{professorId}`
- **Description:** Updates an existing professor's details.
- **Path Parameter:**
    - `professorId` (int): ID of the professor.
- **Request Body:**  [Professor object](#professors-object).
- **Response:** Updated `Professors` object.

---

#### 5. Delete Professor
- **Method:** `DELETE`
- **URL:** `/api/professors/{professorId}`
- **Description:** Deletes a professor by their ID.
- **Path Parameter:**
    - `professorId` (int): ID of the professor.
- **Response:** Confirmation message ("Professor deleted Successfully").

---

#### 6. Get Professors by Class ID
- **Method:** `GET`
- **URL:** `/api/professors/{classId}/classes`
- **Description:** Retrieves a list of professors associated with a specific class.
- **Path Parameter:**
    - `classId` (int): ID of the class.
- **Response:** List of `ProfessorInfoDTO` objects.

---

#### 7. Assign Class to Professor
- **Method:** `POST`
- **URL:** `/api/professors/{professorId}/classes/{classId}`
- **Description:** Assigns a class to a professor.
- **Path Parameters:**
    - `professorId` (int): ID of the professor.
    - `classId` (int): ID of the class.
- **Response:** None.

---

#### 8. Remove Class from Professor
- **Method:** `DELETE`
- **URL:** `/api/professors/{professorId}/classes/{classId}`
- **Description:** Removes a class assignment from a professor.
- **Path Parameters:**
    - `professorId` (int): ID of the professor.
    - `classId` (int): ID of the class.
- **Response:** None.

---

## Classes API


### Endpoints

#### 1. Get All Classes
- **Method:** `GET`
- **URL:** `/api/classes`
- **Description:** Retrieves a list of all classes.
- **Response:** List of [Classes objects](#classes-object).

---

#### 2. Get Class by ID
- **Method:** `GET`
- **URL:** `/api/classes/{classId}`
- **Description:** Retrieves a specific class by its ID.
- **Path Parameter:**
    - `classId` (int): ID of the class.
- **Response:** [Classes object](#classes-object) or 404 if not found.

---

#### 3. Get Classes by Professor ID
- **Method:** `GET`
- **URL:** `/api/professors/{professorId}/classes`
- **Description:** Retrieves a list of classes taught by a specific professor.
- **Path Parameter:**
    - `professorId` (int): ID of the professor.
- **Response:** List of [Classes objects](#classes-object).

---

#### 4. Create Class
- **Method:** `POST`
- **URL:** `/api/classes`
- **Description:** Creates a new class.
- **Request Body:** [Classes object](#classes-object).
- **Response:** Confirmation message ("Class Created Successfully!").

---

#### 5. Update Class
- **Method:** `PUT`
- **URL:** `/api/classes/{classId}`
- **Description:** Updates an existing class's details.
- **Path Parameter:**
    - `classId` (int): ID of the class.
- **Request Body:** [Classes object](#classes-object).
- **Response:** Updated [Classes object](#classes-object) or 409 if conflict occurs.

---

#### 6. Delete Class
- **Method:** `DELETE`
- **URL:** `/api/professors/{professorId}/classes/{classId}`
- **Description:** Deletes a specific class taught by a professor.
- **Path Parameters:**
    - `professorId` (int): ID of the professor.
    - `classId` (int): ID of the class.
- **Response:** None.

---


## Object Structures

### Professors Object
```json
{
  "professorId": 1,
  "firstName": "John",
  "lastName": "Doe",
  "email": "jdoe@schoolmail.com",
  "rating": 8.7
}
```
### Classes Object
```json
{
  "classId": 1,
  "className": "Math 101",
  "classCode": "MATH101",
  "totalStudents": 35,
  "maxStudents": 50,
  "description": "Introduction to Mathematics"
}
```

