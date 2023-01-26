const express = require('express');
const app = express();

const Joi = require('joi')

//to parse application/json body. If not use this, res.body will
//be undefined if body is passed as json
app.use(express.json());

dogs = [
	{id:1, color:"white"},
	{id:2, color: "black"}
]

app.get('/api/dogs/', (req, res) => {
  res.send(dogs)
})

app.get('/api/dogs/:id', (req, res) => {
	//for query string, us req.query
	const dog = dogs.find(d => d.id ===parseInt(req.params.id))

	if (dog) {
		res.send(dog)
	} else {
		res.status(404).send("dog not found")
	}

})

app.post('/api/dogs/', (req, res) => {
	
	//if get error while do validation, send error message and we are done
	const error = validate(req.body)
	if (error) return res.status(400).send(error.details[0].message)
	
	const dog = {
		id: dogs.length + 1,
		color: req.body.color
	};

	dogs.push(dog)
	
	res.send(dog);
});

app.put('/api/dogs/:id', (req, res) => {
	//for query string, us req.query
	let dog = dogs.find(d => d.id ===parseInt(req.params.id))

	if (!dog) return res.status(404).send("dog not found");

	const error = validate(req.body)

	//if get error while do validation, send error message and we are done
	if (error) return res.status(400).send(error.details[0].message)

	dog.color=req.body.color
	res.send(dog)

})

app.delete('/api/dogs/:id', (req, res) => {
	//for query string, us req.query
	const dog = dogs.find(d => d.id ===parseInt(req.params.id))

	if (!dog) return res.status(404).send("dog not found");

	const index = dogs.indexOf(dog)

	//the first parameter is position to start delete. the second is how many to delete
	dogs.splice(index, 1)

	res.send(dog)

})

/**
 * validate request body
 * @param body a request body
 */
function validate(body)
{
	const schema = Joi.object({
		color: Joi.string().min(3).required()
	});

	const { error } = schema.validate({color: body.color})

	return error;

}

//get port from env variable. If not set, use 3000
//to set port env(EXPORT PORT=4000)
const port = process.env.PORT || 3000

app.listen(port, ()=> console.log(`listening on port ${port}....`))

