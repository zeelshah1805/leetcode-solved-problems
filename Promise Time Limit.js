/**
 * @param {Function} fn
 * @param {number} t
 * @return {Function}
 */
var timeLimit = function(fn, t) {
    
    return async function(...args) {
        return new Promise(async (resolve, reject) => {
            const id = setTimeout(() => reject("Time Limit Exceeded"), t);

            try {
                const res = await fn(...args);
                clearTimeout(id);
                resolve(res);
            } catch(err) {
                clearTimeout(id);
                reject(err);
            }
        });
    };
};



