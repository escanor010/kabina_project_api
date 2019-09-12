INSERT INTO business_unit(id,name,manager)
					VALUES	(1, 'Healthcare', 'Duong Nguyen'),
									(2, 'SAP', 'Mai Nguyen'),
									(3, 'Core Delivery 1', 'Ngoc Dang'),
									(4, 'Freshers & Interns', ''),
									(5, 'Insurance', 'Khanh Lam'),
									(6, 'Core Delivery 2', 'Bao Ngo'),
									(7, 'Core Delivery 3', 'Lam Ngo'),
									(8, 'Core Delivery 4', 'Mai Hoang'),
									(9, 'JVDC', 'Thang Dang'),
									(10, 'MD', ''),
									(11, 'EA', ''),
									(12, 'Corporate(RE&F, IT,HR, Finance,SCM, iWFM,BusinessSupport,Process,Security, etc. ', ''),
									(13, 'P&G', '');
        
INSERT INTO shelf(id, position_number,floor, status,business_unit_id)
            VALUES  (NULL, '001',14, 1, 1), (NULL, '002',14, 1, 1),(NULL, '003',14, 1, 1),(NULL, '004',14, 1, 1),(NULL, '005',14, 1, 1),
                    (NULL, '006',14, 1, 1), (NULL, '007',14, 1, 1),(NULL, '008',14, 1, 1),(NULL, '009',14, 1, 1),(NULL, '010',14, 1, 1),
                    (NULL, '011',14, 1, 1), (NULL, '012',14, 1, 1),(NULL, '013',14, 1, 1),(NULL, '014',14, 1, 1),(NULL, '015',14, 1, 1),
                    (NULL, '016',14, 1, 1), (NULL, '017',14, 1, 1),(NULL, '018',14, 1, 1),(NULL, '019',14, 1, 1),(NULL, '020',14, 1, 1),
                    (NULL, '021',14, 1, 1), (NULL, '022',14, 1, 1),(NULL, '023',14, 1, 1),(NULL, '024',14, 1, 1),(NULL, '025',14, 1, 1),
                    (NULL, '026',14, 1, 1), (NULL, '027',14, 1, 1),(NULL, '028',14, 1, 1),(NULL, '029',14, 1, 1),(NULL, '030',14, 1, 1),
                    (NULL, '031',14, 1, 1), (NULL, '032',14, 1, 1),(NULL, '033',14, 1, 1),(NULL, '034',14, 1, 1),(NULL, '035',14, 1, 1),
                    (NULL, '036',14, 1, 1), (NULL, '037',14, 1, 1),(NULL, '038',14, 1, 1),(NULL, '039',14, 1, 1),(NULL, '040',14, 1, 1),
                    (NULL, '041',14, 1, 1), (NULL, '042',14, 1, 1),(NULL, '043',14, 1, 1),(NULL, '044',14, 1, 1),(NULL, '045',14, 1, 1),
                    (NULL, '046',14, 1, 1), (NULL, '047',14, 1, 1),(NULL, '048',14, 1, 1),(NULL, '049',14, 1, 1),(NULL, '050',14, 1, 1),
                    (NULL, '051',14, 1, 1), (NULL, '052',14, 1, 1),(NULL, '053',14, 1, 1),(NULL, '054',14, 1, 1),(NULL, '055',14, 1, 1),
                    (NULL, '056',14, 1, 1), (NULL, '057',14, 1, 1),(NULL, '058',14, 1, 1),(NULL, '059',14, 1, 1),(NULL, '060',14, 1, 1),
                    (NULL, '061',14, 1, 1), (NULL, '062',14, 1, 1),(NULL, '063',14, 1, 1),(NULL, '064',14, 1, 1),(NULL, '065',14, 1, 1),
                    (NULL, '066',14, 1, 1), (NULL, '067',14, 1, 1),(NULL, '068',14, 1, 1),(NULL, '069',14, 1, 1),(NULL, '070',14, 1, 1),
                    (NULL, '071',14, 1, 1), (NULL, '072',14, 1, 1),(NULL, '073',14, 1, 1),(NULL, '074',14, 1, 1),(NULL, '075',14, 1, 1),
                    (NULL, '076',14, 1, 1), (NULL, '077',14, 1, 1),(NULL, '078',14, 1, 1),(NULL, '079',14, 1, 1),(NULL, '080',14, 1, 1),
                    (NULL, '081',14, 1, 1), (NULL, '082',14, 1, 1),(NULL, '083',14, 1, 1),(NULL, '084',14, 1, 1),(NULL, '085',14, 1, 1),
                    (NULL, '086',14, 1, 1), (NULL, '087',14, 1, 1),(NULL, '088',14, 1, 1),(NULL, '089',14, 1, 1),(NULL, '090',14, 1, 1),
                    (NULL, '091',14, 1, 1), (NULL, '092',14, 1, 1),(NULL, '093',14, 1, 1),(NULL, '094',14, 1, 1),(NULL, '095',14, 1, 1),
                    (NULL, '096',14, 1, 1), (NULL, '097',14, 1, 1),(NULL, '098',14, 1, 1),(NULL, '099',14, 1, 1),(NULL, '100',14, 1, 1),
                    (NULL, '101',14, 1, 1), (NULL, '102',14, 1, 1),(NULL, '103',14, 1, 1),(NULL, '104',14, 1, 1),(NULL, '105',14, 1, 1),
                    (NULL, '106',14, 1, 1);


INSERT INTO user(id,username,password,role,full_name,short_name,email,avatar,phone,status, business_unit_id)
    VALUES  (NULL,'chile','123456','User','chi le','chile','chilevan74@gmail.com','https://pickaface.net/gallery/avatar/55315935_161016_0038_2nyrz79.png','0395669219',1,1),
            (NULL,'chilevan','123456','User','chi le van','chilevan','chilevan74@gmail.com','https://pickaface.net/gallery/avatar/55315935_161016_0038_2nyrz79.png','0395669219',1,1),
            (NULL,'quandxc','123456','User','quan dxc','quandxc','quandxc@gmail.com','https://pickaface.net/gallery/avatar/55315935_161016_0038_2nyrz79.png','0395669219',1,1);

INSERT INTO user_shelf(user_id,shelf_id)
        VALUES (1,1),(2,2),(3,6);