-- src/main/resources/data.sql

-- Insert Categories
INSERT INTO category (name) VALUES
                                ('Children Nursery'),
                                ('Children Primary (1-5)'),
                                ('Secondary Education (6-10)'),
                                ('Intermediate'),
                                ('BTech'),
                                ('Others');

-- Insert Standards
INSERT INTO standard (name, category_id) VALUES
                                             ('Standard 1', (SELECT id FROM category WHERE name = 'Children Primary (1-5)')),
                                             ('Standard 2', (SELECT id FROM category WHERE name = 'Children Primary (1-5)')),
                                             ('Standard 3', (SELECT id FROM category WHERE name = 'Children Primary (1-5)')),
                                             ('Standard 4', (SELECT id FROM category WHERE name = 'Children Primary (1-5)')),
                                             ('Standard 5', (SELECT id FROM category WHERE name = 'Children Primary (1-5)')),
                                             ('Standard 6', (SELECT id FROM category WHERE name = 'Secondary Education (6-10)')),
                                             ('Standard 7', (SELECT id FROM category WHERE name = 'Secondary Education (6-10)')),
                                             ('Standard 8', (SELECT id FROM category WHERE name = 'Secondary Education (6-10)')),
                                             ('Standard 9', (SELECT id FROM category WHERE name = 'Secondary Education (6-10)')),
                                             ('Standard 10', (SELECT id FROM category WHERE name = 'Secondary Education (6-10)')),
                                             ('MPC', (SELECT id FROM category WHERE name = 'Intermediate')),
                                             ('BIPC', (SELECT id FROM category WHERE name = 'Intermediate')),
                                             ('CSE', (SELECT id FROM category WHERE name = 'BTech')),
                                             ('EEE', (SELECT id FROM category WHERE name = 'BTech'));

-- Insert Books
INSERT INTO book (title, author, category_id, standard_id, condition, purpose, actual_price, selling_price) VALUES
                                                                                                                ('Maths for Kids', 'John Doe', (SELECT id FROM category WHERE name = 'Children Nursery'), NULL, 'New', 'Education', 200, 150),
                                                                                                                ('Science Book for 1st Grade', 'Jane Smith', (SELECT id FROM category WHERE name = 'Children Primary (1-5)'), (SELECT id FROM standard WHERE name = 'Standard 1'), 'Used', 'Education', 250, 180),
                                                                                                                ('Intermediate Physics', 'Dr. Albert', (SELECT id FROM category WHERE name = 'Intermediate'), (SELECT id FROM standard WHERE name = 'MPC'), 'Good', 'Study', 300, 220);
