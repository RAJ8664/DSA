class Solution {
    static class Rectangle {
        int x1, y1, x2, y2;
        public Rectangle(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
        @Override
        public String toString() {
            return "(" + x1 + " " + y1 + " " + x2 + " " + y2 + ")";
        }
        public int getArea() {
            return Math.abs(x2 - x1) * Math.abs(y2 - y1);
        }
        public static int getIntersectionArea(Rectangle r1, Rectangle r2) {
            int intersectX1 = Math.max(r1.x1, r2.x1);
            int intersectY1 = Math.max(r1.y1, r2.y1);
            int intersectX2 = Math.min(r1.x2, r2.x2);
            int intersectY2 = Math.min(r1.y2, r2.y2);
            if (intersectX1 < intersectX2 && intersectY1 < intersectY2) {
                int width = intersectX2 - intersectX1;
                int height = intersectY2 - intersectY1;
                return width * height;
            }
            return 0;  
        }
        public static int getAreaBetween(Rectangle r1, Rectangle r2) {
            int areaR1 = r1.getArea();
            int areaR2 = r2.getArea();
            int intersectionArea = getIntersectionArea(r1, r2);
            return (areaR1 + areaR2) - intersectionArea;
        }
    }
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        Rectangle r1 = new Rectangle(ax1, ay1, ax2, ay2);
        Rectangle r2 = new Rectangle(bx1, by1, bx2, by2);
        int res = r1.getAreaBetween(r1, r2);
        return res;
    }
}
