const express = require("express")
const myApp = express()

myApp.get("/", (req, res) => {

        res.send("Test Express")

});

myApp.listen(3000, ()=> console.log("listening ...."))
