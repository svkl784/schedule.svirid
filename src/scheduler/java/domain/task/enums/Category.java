package domain.task.enums;

public enum Category {
        WORK("Work"),
        STUDY ("Study"),
        FAMILY("Family"),
        PERSONAL("Personal");
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
