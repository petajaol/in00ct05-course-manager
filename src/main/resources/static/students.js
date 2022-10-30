getStudents();

const studentForm = document.getElementById("studentform");
studentForm.addEventListener("submit", handleAddStudent);

function handleAddStudent() {
  const newStudent = {
    firstName: document.getElementById("firstName").value,
    lastName: document.getElementById("lastName").value,
  };
  postStudent(newStudent);
}

async function getStudents() {
  const students = await fetch("http://localhost:8080/students");
  const json = await students.json();
  showStudents(json);
}

async function postStudent(newStudent) {
  await fetch("http://localhost:8080/students", {
    headers: {
      Accept: "application/json",
      "Content-Type": "application/json",
    },
    method: "POST",
    body: JSON.stringify(newStudent),
  });
}

function showStudents(json) {
  document.getElementById("students").innerHTML = "";
  const studentsTable = document.getElementById("students");
  json.map((student) => {
    const row = studentsTable.insertRow();
    for (const prop in student) {
      row.insertCell().innerHTML = `${student[prop]}`;
    }
  });
}
