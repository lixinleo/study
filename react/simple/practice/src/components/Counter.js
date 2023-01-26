const { render } = require("@testing-library/react");

function Counter(props) {
  return (
    <div>
      <span>{props.value}</span>
      <button onClick={() => props.onClick()}>Increment</button>
      <button onClick={() => props.onDelete()}> Delete</button>
    </div>
  );
}

export default Counter;
