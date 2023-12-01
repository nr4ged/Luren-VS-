
window.watsonAssistantChatOptions = {
  integrationID: "77cb0010-7bfc-49d1-8730-04e39ef8ae8e", // The ID of this integration.
  region: "au-syd", // The region your integration is hosted in.
  serviceInstanceID: "bccecd14-f5b8-45cc-983a-f3d4812322c4", // The ID of your service instance.
  onLoad: function(instance) { instance.render(); }
};
setTimeout(function(){
  const t=document.createElement('script');
  t.src="https://web-chat.global.assistant.watson.appdomain.cloud/versions/" + (window.watsonAssistantChatOptions.clientVersion || 'latest') + "/WatsonAssistantChatEntry.js";
  document.head.appendChild(t);
});


const sideMenu = document.querySelector('aside');
const menuBtn = document.getElementById('menu-btn');
const closeBtn = document.getElementById('close-btn');

const darkMode = document.querySelector('.dark-mode');

menuBtn.addEventListener('click', () => {
sideMenu.style.display = 'block';
});

closeBtn.addEventListener('click', () => {
sideMenu.style.display = 'none';
});

darkMode.addEventListener('click', () => {
document.body.classList.toggle('dark-mode-variables');
darkMode.querySelector('span:nth-child(1)').classList.toggle('active');
darkMode.querySelector('span:nth-child(2)').classList.toggle('active');
})


Orders.forEach(order => {
const tr = document.createElement('tr');
const trContent = `
<td>${order.productName}</td>
<td>${order.productNumber}</td>
<td>${order.paymentStatus}</td>
<td class="${order.status === 'Declined' ? 'danger' : order.status === 'Pending' ? 'warning' : 'primary'}">${order.status}</td>
<td class="primary">Details</td>
`;
tr.innerHTML = trContent;
document.querySelector('table tbody').appendChild(tr);
});
