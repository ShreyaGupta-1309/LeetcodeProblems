class Calculator {
    constructor(value) {
        this.value = value;
    }
    getResult = () => this.value;
    add = (value) => (this.value += value, this);
    subtract = (value) => (this.value -= value, this);
    multiply = (value) => (this.value *= value, this);
    power = (value) => (this.value **= value, this);
    divide(value) {
        if (!value) throw Error('Division by zero is not allowed');
        return (this.value /= value, this);
    }
}