import { TestBed } from '@angular/core/testing';

import { AfferolabService } from './afferolab.service';

describe('AfferolabService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: AfferolabService = TestBed.get(AfferolabService);
    expect(service).toBeTruthy();
  });
});
