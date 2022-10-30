getItems("students");
getItems("courses");

const courseForm = document.getElementById("courseform");
const studentForm = document.getElementById("studentform");
courseForm.addEventListener("submit", handleAddCourse);
studentForm.addEventListener("submit", handleAddStudent);

function handleAddStudent() {
  const newStudent = {
    firstName: document.getElementById("firstName").value,
    lastName: document.getElementById("lastName").value,
  };
  postItem(newStudent, "students");
}

function handleAddCourse() {
  const newCourse = {
    name: document.getElementById("name").value,
    teacher: document.getElementById("teacher").value,
  };
  postItem(newCourse, "courses");
}

async function postItem(item, resource) {
  await fetch(`http://localhost:8080/${resource}`, {
    headers: {
      Accept: "application/json",
      "Content-Type": "application/json",
    },
    method: "POST",
    body: JSON.stringify(item),
  });
}

async function getItems(resource) {
  const items = await fetch(`http://localhost:8080/${resource}`);
  const json = await items.json();
  showItemsInTable(json, resource);
}

function showItemsInTable(json, resource) {
  document.getElementById(resource).innerHTML = "";
  const table = document.getElementById(resource);
  json.map((course) => {
    const row = table.insertRow();
    for (const prop in course) {
      row.insertCell().innerHTML = `${course[prop]}`;
    }
  });
}
