package domain.enums;

public enum Priority {
        HIGH("High"),
        MEDIUM("Medium"),
        LOW("Low");
        private String priority;

        Priority(String priority) {
            this.priority = priority;
        }

        @Override
        public String toString() {
            return priority;
        }

        public String getPriority() {
            return priority;
        }
    }

