package domain.enums;

public enum Category {
        IN_WORK("In work"),
        POSTPONED("Postponed"),
        VERIFY("Verify"),
        PERFORMED("Performed");
        private String category;

        Category(String category) {
            this.category = category;
        }

        @Override
        public String toString() {
            return category;
        }

        public String getCategory() {
            return category;
        }
}
