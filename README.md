# Read the existing README.md file to see its current contents
readme_path = os.path.join(extract_dir, "QuizHub", "README.md")
with open(readme_path, "r", encoding="utf-8") as f:
    readme_contents = f.read()

readme_contents[:1000]  # Display the first 1000 characters of README.md for review
