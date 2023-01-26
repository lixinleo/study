import logo from "./logo.svg";
import React from "react";
import ReactDOM from "react-dom";

import Counter from "./components/Counter";

class App extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      counters: [
        { id: 1, value: 0 },
        { id: 2, value: 0 },
        { id: 3, value: 0 },
        { id: 4, value: 0 },
      ],
      total: 0,
    };
  }

  handleIncr(i) {
    let newState = this.state.counters.slice();

    for (let j = 0; j < newState.length; j++) {
      let counter = newState[j];
      if (counter.id === i) {
        newState[j].value = newState[j].value + 1;
      }
    }

    this.setState({ counters: newState, total: this.state.total + 1 });
  }

  handleDelete(i) {
    let total = 0;
    let newCounts = [];

    let myState = this.state.counters.slice();

    for (let j = 0; j < myState.length; j++) {
      let counter = myState[j];
      if (counter.id != i) {
        newCounts.push(counter);
        total = total + counter.value;
      }
    }

    this.setState({ counters: newCounts, total: total });
  }

  renderCount(counter) {
    return (
      <Counter
        value={counter.value}
        id={counter.id}
        onClick={() => this.handleIncr(counter.id)}
        onDelete={() => this.handleDelete(counter.id)}
      />
    );
  }

  handleReset() {
    let counters = [
      { id: 1, value: 0 },
      { id: 2, value: 0 },
      { id: 3, value: 0 },
      { id: 4, value: 0 },
    ];

    this.setState({ counters: counters, total: 0 });
  }

  renderCounts() {
    return this.state.counters.map((counter) => this.renderCount(counter));
  }

  render() {
    return (
      <div>
        <label>Total:{this.state.total}</label>
        <button onClick={() => this.handleReset()} style={{ marginLeft: 5 }}>
          Reset
        </button>
        {this.renderCounts()}
      </div>
    );
  }
}

export default App;
