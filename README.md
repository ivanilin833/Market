# Market
1. Принцип избегания магических чисел - создание переменных для контроля цен
https://github.com/ivanilin833/Market/blob/62bfc1f20faf6fc26f413e7e22c41f50505628be/src/Main.java#L17-L18
2. Принцип DRY - создание метода который выводит меню
   https://github.com/ivanilin833/Market/blob/62bfc1f20faf6fc26f413e7e22c41f50505628be/src/Main.java#L66-L76
3. Принцип единственной ответственности и Принцип открытости/закрытости- отдельные классы для сотрудников магазина, каждый отвечает за свое, но все расширяют общий класс работника
https://github.com/ivanilin833/Market/blob/62bfc1f20faf6fc26f413e7e22c41f50505628be/src/workers/Worker.java#L1-L22
https://github.com/ivanilin833/Market/blob/62bfc1f20faf6fc26f413e7e22c41f50505628be/src/workers/Seller.java#L1-L18
https://github.com/ivanilin833/Market/blob/62bfc1f20faf6fc26f413e7e22c41f50505628be/src/workers/Manager.java#L1-L22
4. Принцип сегрегации (разделения) интерфейса - интерфейс Filter который отвечает только за фильтрацию
   https://github.com/ivanilin833/Market/blob/62bfc1f20faf6fc26f413e7e22c41f50505628be/src/filters/Filter.java#L1-L7
5. Принцип инверсии зависимостей
   https://github.com/ivanilin833/Market/blob/62bfc1f20faf6fc26f413e7e22c41f50505628be/src/Main.java#L78-L101
