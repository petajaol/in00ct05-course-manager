getItems("students");
getItems("courses");

const studentForm = document.getElementById("studentform");
const courseForm = document.getElementById("courseform");
const enrolmentForm = document.getElementById("enrolmentform");

courseForm.addEventListener("submit", (event) => handleSubmit(event));
studentForm.addEventListener("submit", (event) => handleSubmit(event));
enrolmentForm.addEventListener("submit", (event) => handleSubmit(event));

function handleSubmit(event) {
  event.preventDefault();
  let body, resource;
  if (event.target.id === "studentform") {
    body = {
      firstName: document.getElementById("firstName").value,
      lastName: document.getElementById("lastName").value,
    };
    resource = "students";
  }
  if (event.target.id === "courseform") {
    body = {
      name: document.getElementById("name").value,
      teacher: document.getElementById("teacher").value,
    };
    resource = "courses";
  }
  if (event.target.id === "enrolmentform") {
    body = {
      studentId: document.getElementById("studentId").value,
      courseId: document.getElementById("courseId").value,
    };
    resource = "enrolment";
  }
  postItem(body, resource);
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

  if (resource !== "enrolment") {
    const item = await response.json();
    showItemInTable(item, resource);
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
