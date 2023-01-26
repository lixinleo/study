import React from 'react';
import ReactDOM from 'react-dom';

class Calculator extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      inputVal: 0,
      outputVal: 0
    };
}

  handleChange(myVal) {
    console.log("myVal", myVal)
    this.setState({inputVal:myVal, outputVal: Math.sqrt(myVal).toFixed(2)})
  }

  render() {
    return (
      <div>
        <p>Calculate Square Root</p>
        <input type="text" value = {this.state.inputVal}
          onChange = {(event)=>this.handleChange(event.target.value)}
        />
      <br />
        <span>{this.state.outputVal}</span>
      </div>
    );
  }
}

ReactDOM.render(
  <Calculator />,
  document.getElementById('root')
);


