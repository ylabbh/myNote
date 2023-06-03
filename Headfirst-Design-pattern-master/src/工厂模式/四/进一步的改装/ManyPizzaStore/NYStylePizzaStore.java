package 工厂模式.四.进一步的改装.ManyPizzaStore;

        import 工厂模式.四.进一步的改装.ManyPizza.CheesePizza;
        import 工厂模式.四.进一步的改装.ManyPizza.ClamPizza;
        import 工厂模式.四.进一步的改装.ManyPizza.Pizza;
        import 工厂模式.四.进一步的改装.原料管理.Cheese.Cheese;
        import 工厂模式.四.进一步的改装.原料管理.NYPizzaIngredientFactory;
        import 工厂模式.四.进一步的改装.原料管理.PizzaIngredientFactory;

public class NYStylePizzaStore extends PizzaStore {

    //new对象的方式统一管理
    /*
     * 改造：每个地区加盟店
     */
    @Override
    public Pizza pizzaFactory(String type) {
        Pizza pizza = null;
        PizzaIngredientFactory ingredientFactory =  new NYPizzaIngredientFactory();
        switch (type){
            case "cheese":
                pizza = new CheesePizza(ingredientFactory);
                pizza.setName("New York Style Cheese Pizza");
                break;
            case "clam":
                pizza = new ClamPizza(ingredientFactory);
                pizza.setName("New York Style Clam Pizza");
                break;
        }
        return pizza;
    }
}
