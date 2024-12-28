ALTER TABLE teslim_sureleri
DROP
CONSTRAINT fk_kabul_ili;

ALTER TABLE teslim_sureleri
DROP
CONSTRAINT fk_varis_ili;

ALTER TABLE teslim_sureleri
    ADD teslim_gunu INTEGER;

ALTER TABLE teslim_sureleri
    ALTER COLUMN teslim_gunu SET NOT NULL;

ALTER TABLE teslim_sureleri
    ADD CONSTRAINT "pk_teslım_surelerı" PRIMARY KEY (id);

DROP SEQUENCE city_seq CASCADE;