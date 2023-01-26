import React, { Component } from 'react';
class Counter extends Component {


    render() { 

        return (<div>
            <span  className={this.getButtonClass()}>{this.formatCount()}</span>
		<button onClick={()=>this.props.onIncrement(this.props.counter)} className="btn btn-secondary btn-sm">Increment</button> 

		<button onClick={() =>this.props.onDelete(this.props.id)}  className="btn btn-danger btn-sm m-2">Delete</button>
            </div>);
    }

	formatCount() {
		const value = this.props.counter.value;
		return value===0 ? "Zero" : value
	}

	getButtonClass() {
		 let classes = "badge m-2 badge-";
            classes += this.props.counter.value===0 ? "warning" : "primary";
		return classes;

	}
}

export default Counter ;
