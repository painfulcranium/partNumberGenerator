import { TestBed } from '@angular/core/testing';

import { PartNumberService } from './part-number.service';

describe('PartNumberService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: PartNumberService = TestBed.get(PartNumberService);
    expect(service).toBeTruthy();
  });
});
