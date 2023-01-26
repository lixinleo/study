import React, { Component } from 'react';
import Counter from "./counter";

class Counters extends Component {
	state = {
		counters: [
			{id:1, value:0},
			{id:2, value:0},
			{id:3, value:0},
			{id:4, value:0}
		]
	};

	handleIncrement = (counter)=> {
		const counters = [...this.state.counters];

		const index = counters.indexOf(counter);
		console.log("index", index);

		counters[index] = {...counter};
		counters[index].value++;

		console.log("counters", counters);

		this.setState({counters});
	};

	handleDelete = (counterId) => {
		console.log("Event handler called", counterId);
		const counters = this.state.counters.filter(c=>c.id !=counterId);
		console.log(counters)
		this.setState({counters:counters})
	};

	handleReset = () => {
		console.log("reste click")
	const counters =	this.state.counters.map(c=>{
			c.value =0;
			return c;
		});
		
		console.log(counters)

		this.setState({counters});
	};


    render() { 

        return (<div>

		<button onClick={this.handleReset} className="btn btn-primary btn-sm m-2">Reset</button>
		{this.state.counters.map(counter=>
			<Counter  onIncrement={this.handleIncrement}  counter={counter} key={counter.id} onDelete={this.handleDelete}  id={counter.id} /> )   }	
		</div>);
    }

}

export default Counters ;
