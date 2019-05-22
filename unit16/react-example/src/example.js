var React = require('react');
var ReactDom = require('react-dom');

function Hola(props) {
    return <h1>Hola, {props.name}</h1>
}

ReactDom.render(<Hola name={"Mercado Libre"}/>,
    document.getElementById('hello-meli'));

class Hello2 extends React.Component {
    render() {
        return <h1>Hola {this.props.name}</h1>
    }
}

ReactDom.render(<Hello2 name={"Mercado Libre"}/>,
    document.getElementById('hello-meli'));
