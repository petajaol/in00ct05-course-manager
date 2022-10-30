getItems("students");
getItems("courses");

const studentForm = document.getElementById("studentform");
const courseForm = document.getElementById("courseform");

courseForm.addEventListener("submit", (event) => handleSubmit(event));
studentForm.addEventListener("submit", (event) => handleSubmit(event));

function handleSubmit(event) {
  let item, resource;
  if (event.target.id === "studentform") {
    item = {
      firstName: document.getElementById("firstName").value,
      lastName: document.getElementById("lastName").value,
    };
    resource = "students";
  }
  if (event.target.id === "courseform") {
    item = {
      name: document.getElementById("name").value,
      teacher: document.getElementById("teacher").value,
    };
    resource = "courses";
  }
  postItem(item, resource);
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
