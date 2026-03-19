const API = "/tasks";

function loadTasks() {

    fetch(API)
        .then(response => response.json())
        .then(data => {

            const list = document.getElementById("taskList");
            list.innerHTML = "";

            let completed = data.filter(task => task.completed).length;
            let remaining = data.length - completed;

            document.getElementById("taskCount").innerText =
                "Total Tasks: " + data.length;

            document.getElementById("remainingCount").innerText =
                "Remaining Tasks: " + remaining;

            data.forEach(task => {

                const li = document.createElement("li");

                const checkbox = document.createElement("input");
                checkbox.type = "checkbox";
                checkbox.checked = task.completed;

                checkbox.onchange = () => toggleTask(task);

                const span = document.createElement("span");
                span.innerText = task.description;

                if (task.completed) {
                    span.style.textDecoration = "line-through";
                }
                const editBtn = document.createElement("button");
                editBtn.innerText = "Edit";

                editBtn.onclick = () => editTask(task);

                const deleteBtn = document.createElement("button");
                deleteBtn.innerText = "Delete";

                deleteBtn.onclick = () => deleteTask(task.id);

                li.appendChild(checkbox);
                li.appendChild(span);
                li.appendChild(editBtn);
                li.appendChild(deleteBtn);

                list.appendChild(li);

            });

        });

}

function addTask() {

    const input = document.getElementById("taskInput");

    if (input.value.trim() === "") {
        return;
    }

    fetch(API, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            description: input.value,
            completed: false
        })
    })
        .then(() => {
            input.value = "";
            loadTasks();
        });

}

function deleteTask(id) {

    fetch(API + "/" + id, {
        method: "DELETE"
    })
        .then(loadTasks);

}

function toggleTask(task) {

    fetch(API + "/" + task.id, {
        method: "PUT",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            description: task.description,
            completed: !task.completed
        })
    })
        .then(loadTasks);

}

loadTasks();
function editTask(task) {

    let newText = prompt("Edit your task:", task.description);

    if(newText === null || newText.trim() === ""){
        return;
    }

    fetch(API + "/" + task.id, {

        method: "PUT",

        headers:{
            "Content-Type":"application/json"
        },

        body: JSON.stringify({
            description: newText,
            completed: task.completed
        })

    })
        .then(loadTasks);

}