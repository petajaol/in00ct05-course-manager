getItems("students");
getItems("courses");

const studentForm = document.getElementById("student-form");
const courseForm = document.getElementById("course-form");
const enrolmentForm = document.getElementById("enrolment-form");

courseForm.addEventListener("submit", (event) => handleSubmit(event));
studentForm.addEventListener("submit", (event) => handleSubmit(event));
enrolmentForm.addEventListener("submit", (event) => handleSubmit(event));

function handleSubmit(event) {
  event.preventDefault();
  let body, resource;
  if (event.target.id === "student-form") {
    body = {
      firstName: document.getElementById("firstName").value,
      lastName: document.getElementById("lastName").value,
    };
    resource = "students";
    document.getElementById("firstName").value = "";
    document.getElementById("lastName").value = "";
  }
  if (event.target.id === "course-form") {
    body = {
      name: document.getElementById("name").value,
      teacher: document.getElementById("teacher").value,
    };
    resource = "courses";
    document.getElementById("name").value = "";
    document.getElementById("teacher").value = "";
  }
  if (event.target.id === "enrolment-form") {
    body = {
      studentId: document.getElementById("studentId").value,
      courseId: document.getElementById("courseId").value,
    };
    resource = "enrolment";
    document.getElementById("studentId").value = "";
    document.getElementById("courseId").value = "";
  }
  if (!validateItem(body)) {
    return;
  }
  postItem(body, resource);
}

function validateItem(body) {
  for (const prop in body) {
    if (body[prop] === "") {
      alert("LACKS CRITICAL INFORMATION");
      return false;
    }
  }
  return true;
}

function validateEnrolment(response) {
  if (!response) {
    alert("COURSE OR STUDENT DOESN'T EXIST");
  }
}

async function postItem(body, resource) {
  const response = await fetch(`http://localhost:8080/${resource}`, {
    headers: {
      Accept: "application/json",
      "Content-Type": "application/json",
    },
    method: "POST",
    body: JSON.stringify(body),
  });

  const responseBody = await response.json();

  if (resource === "enrolment") {
    validateEnrolment(responseBody);
  } else {
    showItemInTable(responseBody, resource);
  }
}

async function getItems(resource) {
  const response = await fetch(`http://localhost:8080/${resource}`);
  const items = await response.json();
  showItemsInTable(items, resource);
}

function showItemsInTable(items, resource) {
  const table = document.getElementById(resource);
  document.getElementById(resource).innerHTML = "";
  items.map((item) => {
    const row = table.insertRow();
    for (const prop in item) {
      row.insertCell().innerHTML = `${item[prop]}`;
    }
  });
}

function showItemInTable(item, resource) {
  const table = document.getElementById(resource);
  const row = table.insertRow();
  for (const prop in item) {
    row.insertCell().innerHTML = `${item[prop]}`;
  }
}
