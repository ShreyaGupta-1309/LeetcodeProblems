/**
 * @param {integer} init
 * @return { increment: Function, decrement: Function, reset: Function }
 */
var createCounter = function(init) {
    let count = init;
    const increment = function() {
        count++;
        return count;
    };
    const reset = function() {
        return count = init;
    };
    const decrement = function() {
        count--
        return count;
    }

    return {increment, reset, decrement};
};

/**
 * const counter = createCounter(5)
 * counter.increment(); // 6
 * counter.reset(); // 5
 * counter.decrement(); // 4
 */