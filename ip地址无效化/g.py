import numpy as np
import seaborn as sns
import pandas as pd
import matplotlib.pyplot as plt


def confusion_matrix(y_true, y_pred, labels=None):
    n = len(labels)
    labels_dict = {label: i for i, label in enumerate(labels)}
    res = np.zeros([n, n], dtype=np.int32)
    for gold, predict in zip(y_true, y_pred):
        res[labels_dict[gold]][labels_dict[predict]] += 1

    df = pd.DataFrame(res, index=labels, columns=labels)
    sns.heatmap(df, annot=True, fmt='d')
    plt.savefig("./confusion_matrix.jpg")
    plt.show()

y_true = ["cat", "ant", "cat", "cat", "ant", "bird"]  # 真实
y_pred = ["ant", "ant", "cat", "cat", "ant", "cat"]  # 预测
labels = ["ant", "bird", "cat"]

confusion_matrix(y_true, y_pred, labels)