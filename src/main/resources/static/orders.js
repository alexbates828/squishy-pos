var prices = [];
let priceDisplayId = "priceDisplay";

function resetPriceDisplay() {
    document.getElementById(priceDisplayId).value = 0.00;
}

function getPriceDisplay() {
    return document.getElementById(priceDisplayId).value;
}

function handleAdd() {
    let price = getPriceDisplay();
    console.log("Price displayed:" + price);
    addPrice(price);
    updatePricesDisplay();
    resetPriceDisplay();
}

function handleSubtract() {
    let price = getPriceDisplay();
    console.log("Price displayed:" + price);
    removePrice(price);
    updatePricesDisplay();
    resetPriceDisplay();
}

function addPrice(price) {
    prices.push(price);
}

function getPrices() {
    return prices;
}

function removePrice(price) {
    prices.push(-price);
}

function updatePricesDisplay() {
    console.log("Prices: " + prices);
}

function resetPricesDisplay() {
    prices = [];
    updatePricesDisplay();
}

function showTotal(total) {
    console.log(total);
}

function handleFinish() {
    // TODO: make this an API call
    let total = sumArray(prices);
    resetPricesDisplay();
    resetPriceDisplay();
    showTotal(total)
}

function sumArray(arr) {
    return arr.reduce((a, b) => a + parseFloat(b), 0);
}
