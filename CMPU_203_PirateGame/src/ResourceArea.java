public class ResourceArea extends ASurrounding{

        public ResourceArea() {
            symbol = "X";
            double x = Math.random();
            if(x <= 0.33) {description = "rope";}
            else if(x <= 0.66) {description = "wood";}
            else {description = "medicine";}
        }

        public String getSymbol() {
            return symbol;
        }

        public String displayCards() {
            return "Oh look! Some " + description;
        }

}


