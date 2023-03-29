const html = {
    exampleModal1: document.getElementById("exampleModal1"),
    exampleModal2: document.getElementById("exampleModal2"),
    loginButton: document.getElementById("login"),
    registerButton: document.getElementById("register"),
    closeButton: document.getElementById("close"),
    title: document.getElementById("title"),
    search: document.getElementById("search"),
    searchSubmit: document.getElementById("searchSubmit"),
    back: document.getElementById("back"),
    backButton: document.getElementById("backButton"),
    accountButton: document.getElementById("accountButton"),
    sectionAction: document.getElementById("sectionAction")
};

html.title.style.display = "block";
html.search.style.display = "block";
html.backButton.style.display = "none";
html.exampleModal1.style.display = "none";
html.exampleModal2.style.display = "none";
html.sectionAction.style.display = "none";


html.accountButton.addEventListener("click", () => {
    console.log("accountButton");
    html.exampleModal2.display = "block";
})

html.loginButton.addEventListener("click", () => {
    console.log("login");
    html.exampleModal1.style.display = "none";
    html.exampleModal2.style.display = "block";
})

html.registerButton.addEventListener("click", () => {
    console.log("register");
    html.exampleModal2.style.display = "none";
    html.exampleModal1.style.display = "block";
})

html.closeButton.addEventListener("click", () => {
    console.log("close");
    html.exampleModal2.style.display = "none";
    html.exampleModal1.style.display = "none";
})

html.searchSubmit.addEventListener("click", () => {
    console.log("searchSubmit");
    html.title.style.display = "none";
    html.search.style.display = "none";
    html.backButton.style.display = "block";
    html.sectionAction.style.display = "block";
})


html.back.addEventListener("click", () => {
    console.log("Return");
    html.title.style.display = "block";
    html.search.style.display = "block";
    html.backButton.style.display = "none";
    html.sectionAction.style.display = "none";
})