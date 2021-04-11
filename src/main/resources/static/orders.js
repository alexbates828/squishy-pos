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
    console.log("Price displayed:" + price)
    addPrice(price);
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
    return;
}