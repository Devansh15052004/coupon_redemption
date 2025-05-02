import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
from itertools import combinations

# Load dataset
df = pd.read_csv('books.csv')

# Function to calculate support
def support(df, items):
    return np.mean(df[list(items)].all(axis=1))

# Apriori rule generation
def generate_rules(df, min_support=0.3, min_confidence=0.6, min_length=2):
    cols = df.columns
    rules = []

    for L in range(min_length, len(cols) + 1):
        for itemset in combinations(cols, L):
            sup = support(df, itemset)
            if sup >= min_support:
                for i in range(1, L):
                    for antecedent in combinations(itemset, i):
                        consequent = tuple(set(itemset) - set(antecedent))
                        if consequent:
                            conf = support(df, itemset) / support(df, antecedent)
                            if conf >= min_confidence:
                                rules.append((antecedent, consequent, sup, conf))
    return pd.DataFrame(rules, columns=["Antecedent", "Consequent", "Support", "Confidence"])

# Try different support/confidence values
rules1 = generate_rules(df, min_support=0.3, min_confidence=0.6)
rules2 = generate_rules(df, min_support=0.2, min_confidence=0.5)

# Plot support vs confidence
plt.scatter(rules1['Support'], rules1['Confidence'], label='Support≥0.3')
plt.scatter(rules2['Support'], rules2['Confidence'], label='Support≥0.2', alpha=0.6)
plt.xlabel("Support")
plt.ylabel("Confidence")
plt.title("Support vs Confidence")
plt.legend()
plt.grid(True)
plt.show()
